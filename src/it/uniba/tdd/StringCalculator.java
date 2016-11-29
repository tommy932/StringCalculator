package it.uniba.tdd;

public class StringCalculator {

	public int add(String numbersStr) throws StringCalculatorException {
		// Returns the sum of the numbers given in numbersStr

		if (numbersStr.isEmpty()) {
			return 0;
		}

		else if (numbersStr.length() == 1) {
			return Integer.parseInt(numbersStr);
		}

		else {

			char delimitator;
			if (numbersStr.contains("//")) {
				delimitator = numbersStr.charAt(2);
				numbersStr = numbersStr.replace("//" + delimitator + "\n", "");
				if (numbersStr.contains(delimitator + "\n") || numbersStr.contains("\n" + delimitator))
					throw new StringCalculatorException("Format number error.");
			} else {
				delimitator = ',';
				if (numbersStr.contains(",\n") || numbersStr.contains("\n,"))
					throw new StringCalculatorException("Format number error.");
			}
			if (numbersStr.contains("--") && delimitator == '-' || numbersStr.contains("-") && delimitator != '-')
				throw new StringCalculatorException("Format number error.");

			int total = 0;
			int n = 0;
			String split[] = numbersStr.split("(" + delimitator + ")|(\\\n)");
			for (String number : split) {
				n = Integer.parseInt(number);
				if (n < 1000)
					total += n;
			}
			return total;
		}

	}
}