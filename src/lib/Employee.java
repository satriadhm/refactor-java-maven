package lib;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Date;

public class Employee extends Person {

	private String employeeId;
	private Date joinedDate;
	private int monthWorkingInYear;
	private AdditionalInformation additionalInformation;
	private Compensation compensation;

	public Employee(String employeeId, Person person,
			Date joinedDate, boolean isForeigner, Gender gender) {
		super(person.getFirstName(), person.getLastName(), person.getIdNumber(), person.getAddress(),
				person.getGender());
		setEmployeeId(employeeId);
		additionalInformation = new AdditionalInformation(isForeigner, "", "", new LinkedList<String>(),
				new LinkedList<String>());
		this.gender = gender;
		compensation = new Compensation();
		compensation.setAnnualDeductible(0);
		compensation.setAdditionalIncome(0);
		compensation.setMonthlySalary(0);

	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
			if (additionalInformation.getIsForeigner()) {
				compensation.setMonthlySalary((int) (3000000 * 1.5));
			}
		} else if (grade == 2) {
			compensation.setMonthlySalary(5000000);
			if (additionalInformation.getIsForeigner()) {
				compensation.setMonthlySalary((int) (3000000 * 1.5));
			}
		} else if (grade == 3) {
			compensation.setMonthlySalary(7000000);
			if (additionalInformation.getIsForeigner()) {
				compensation.setMonthlySalary((int) (3000000 * 1.5));
			}
		}
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
				additionalInformation.getSpouseIdNumber().equals(""), additionalInformation.getChildIdNumbers().size());
	}
}
