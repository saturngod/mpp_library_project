package business.usecases;

import business.models.CheckOutRecord;

public interface PrintCheckOutRecordUseCase {
	public CheckOutRecord getCheckOutRecord(String memberId);
}
