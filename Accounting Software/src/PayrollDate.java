import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class PayrollDate {
	
	private int periodNumber;
	private int insWeeks;
	private LocalDate payrollDate;
	private LocalDate chequeDate;
	private LocalDate giroDate;
	private LocalDate bankDate;
	private int costYear;
	private int costPeriod;
	
	PayrollDate()
	{
		this.periodNumber = 0;
		this.insWeeks = 0;
		this.payrollDate = null;
		this.chequeDate = null;
		this.giroDate = null;
		this.bankDate = null;
		this.costYear = 0;
		this.costPeriod = 0;
	}
	
	PayrollDate(int periodNumber, int insWeeks, LocalDate payrollDate)
	{
		this.periodNumber = periodNumber;
		this.insWeeks = insWeeks;
		this.payrollDate = payrollDate;
		this.chequeDate = payrollDate.minusDays(1);
		this.giroDate = chequeDate;
		this.bankDate = chequeDate;
		this.costYear = chequeDate.getYear();
		this.costPeriod = periodNumber;
	}

	public int getPeriodNumber() {
		return periodNumber;
	}

	public void setPeriodNumber(int periodNumber) {
		this.periodNumber = periodNumber;
	}

	public int getInsWeeks() {
		return insWeeks;
	}

	public void setInsWeeks(int insWeeks) {
		this.insWeeks = insWeeks;
	}

	public String getPayrollDate() {
		return payrollDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
	}

	public void setPayrollDate(LocalDate payrollDate) {
		this.payrollDate = payrollDate;
	}

	public String getChequeDate() {
		return chequeDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
	}

	public void setChequeDate(LocalDate chequeDate) {
		this.chequeDate = chequeDate;
	}

	public String getGiroDate() {
		return giroDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
	}

	public void setGiroDate(LocalDate giroDate) {
		this.giroDate = giroDate;
	}

	public String getBankDate() {
		return bankDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
	}

	public void setBankDate(LocalDate bankDate) {
		this.bankDate = bankDate;
	}

	public int getCostYear() {
		return costYear;
	}

	public void setCostYear(int costYear) {
		this.costYear = costYear;
	}

	public int getCostPeriod() {
		return costPeriod;
	}

	public void setCostPeriod(int costPeriod) {
		this.costPeriod = costPeriod;
	}

}
