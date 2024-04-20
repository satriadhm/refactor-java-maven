package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;

public class Employee extends Person {

	private String employeeId;

	private Date joinedDate;
	private int monthWorkingInYear;

	private boolean isForeigner;

	private String spouseName;
	private String spouseIdNumber;
	private Compensation compensation;

	private List<String> childNames;
	private List<String> childIdNumbers;

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address,
			Date joinedDate, boolean isForeigner, Gender gender) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.joinedDate = joinedDate;
		this.isForeigner = isForeigner;
		this.gender = gender;
		childNames = new LinkedList<String>();
		childIdNumbers = new LinkedList<String>();
		compensation = new Compensation();
		compensation.setAnnualDeductible(0);
		compensation.setAdditionalIncome(0);
		compensation.setMonthlySalary(0);

	}

	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya
	 * (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3:
	 * 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */

	public void setSalary(int grade) {
		if (grade == 1) {
			compensation.setMonthlySalary(3000000);
			if (isForeigner) {
				compensation.setMonthlySalary((int) (3000000 * 1.5));
			}
		} else if (grade == 2) {
			compensation.setMonthlySalary(5000000);
			if (isForeigner) {
				compensation.setMonthlySalary((int) (3000000 * 1.5));
			}
		} else if (grade == 3) {
			compensation.setMonthlySalary(7000000);
			if (isForeigner) {
				compensation.setMonthlySalary((int) (3000000 * 1.5));
			}
		}
	}

	public void setSpouse(String spouseName, String spouseIdNumber) {
		this.spouseName = spouseName;
		this.spouseIdNumber = idNumber;
	}

	public void addChild(String childName, String childIdNumber) {
		childNames.add(childName);
		childIdNumbers.add(childIdNumber);
	}

	public int getAnnualIncomeTax() {

		// Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah
		// bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		int yearJoined = joinedDate.getYear();
		int monthJoined = joinedDate.getMonth();

		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		} else {
			monthWorkingInYear = 12;
		}

		return TaxFunction.calculateTax(compensation.getMonthlySalary(), compensation.getOtherMonthlyIncome(),
				monthWorkingInYear, compensation.getAnnualDeductible(),
				spouseIdNumber.equals(""), childIdNumbers.size());
	}
}
