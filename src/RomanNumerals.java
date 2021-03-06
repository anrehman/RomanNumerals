
public class RomanNumerals {
	public int convertToInteger(String romanNum) throws RomanNumeralException {
		char[] rommanNumArray = romanNum.toCharArray();
		int result = 0;
		int loop = (rommanNumArray.length - 1);

		validateRomanString(rommanNumArray);

		while (loop >= 0) {
			if (loop - 1 >= 0 && checkIfFirstIsSmall(rommanNumArray[loop - 1], rommanNumArray[loop])) {
				if (checkIfSecondHightest(rommanNumArray[loop - 1], rommanNumArray[loop])) {
					result = result
							+ (checkSingleNumeral(rommanNumArray[loop]) - checkSingleNumeral(rommanNumArray[loop - 1]));
					loop = loop - 2;
				} else
					throw new RomanNumeralException();
			} else {
				result = result + checkSingleNumeral(rommanNumArray[loop]);
				loop--;
			}
		}
		return result;
	}

	private boolean checkIfSecondHightest(char c, char d) {
		boolean result = false;
		String orderString = "IVXLCDM";
		int indexC = orderString.indexOf(c);
		int indexD = orderString.indexOf(d);
		if ((indexD - indexC) <= 2 && (c == 'I' || c == 'C' || c == 'X'))
			result = true;
		return result;
	}

	private void validateRomanString(char[] rommanNumArray) throws RomanNumeralException {
		int countI = 0;
		int countX = 0;
		int countM = 0;
		int countC = 0;
		int countV = 0;
		int countL = 0;
		int countD = 0;

		for (int loop = 0; loop < rommanNumArray.length; loop++) {
			for (int innerLoop = (loop + 2); innerLoop < rommanNumArray.length; innerLoop++) {
				if (checkSingleNumeral(rommanNumArray[loop]) < checkSingleNumeral(rommanNumArray[innerLoop]))
					throw new RomanNumeralException();
			}
			if (rommanNumArray[loop] == 'V') {
				countV++;
				countI = 0;
				countX = 0;
				countM = 0;
				countC = 0;
			} else if (rommanNumArray[loop] == 'X') {
				countX++;
				countI = 0;
				countM = 0;
				countC = 0;
			} else if (rommanNumArray[loop] == 'I') {
				countI++;
				countX = 0;
				countM = 0;
				countC = 0;
			} else if (rommanNumArray[loop] == 'M') {
				countM++;
				countI = 0;
				countX = 0;
				countC = 0;
			} else if (rommanNumArray[loop] == 'C') {
				countC++;
				countI = 0;
				countX = 0;
				countM = 0;
			} else if (rommanNumArray[loop] == 'L') {
				countL++;
				countI = 0;
				countX = 0;
				countM = 0;
				countC = 0;
			} else if (rommanNumArray[loop] == 'D') {
				countD++;
				countI = 0;
				countX = 0;
				countM = 0;
				countC = 0;
			}
		}

		if (countI > 3 || countX > 3 || countM > 3 || countC > 3 || countV > 1 || countL > 1 || countD > 1) {
			throw new RomanNumeralException();
		}
	}

	private boolean checkIfFirstIsSmall(char c, char d) {
		boolean result = false;
		if (checkSingleNumeral(c) < checkSingleNumeral(d)) {
			result = true;
		}
		return result;
	}

	public int checkSingleNumeral(char numberal) {
		if (numberal == 'V')
			return 5;
		else if (numberal == 'X')
			return 10;
		else if (numberal == 'L')
			return 50;
		else if (numberal == 'C')
			return 100;
		else if (numberal == 'D')
			return 500;
		else if (numberal == 'M')
			return 1000;
		else
			return 1;
	}
}
