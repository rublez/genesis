package io.genesis.cryptowalletperformance.service;

import java.io.Reader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import io.genesis.cryptowalletperformance.dto.WalletAsset;

@Service
public class WalletService {

	public List<WalletAsset> getWalletData() throws Exception {
		Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource("wallet.csv").toURI()));

		return readAllLines(reader);

	}

	private List<WalletAsset> readAllLines(final Reader reader) throws Exception {
		CSVParser parser = new CSVParserBuilder().withSeparator(',').withIgnoreLeadingWhiteSpace(true).withIgnoreQuotations(true).build();
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).withCSVParser(parser).build();
		List<String[]> walletData = new ArrayList<>(csvReader.readAll());
		reader.close();
		csvReader.close();

		return convertArrayToObject(walletData);

	}

	private List<WalletAsset> convertArrayToObject(final List<String[]> walletDataArray) {
		List<WalletAsset> walletAssets = new ArrayList<>();
		for (String[] value : walletDataArray) {
			walletAssets
					.add(new WalletAsset(String.valueOf(value[0]), new BigDecimal(value[1]), new BigDecimal(value[2])));

		}
		return walletAssets;

	}

}
