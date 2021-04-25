package tekstbestand.domein;

import java.util.List;

import tekstbestand.persistentie.AccountRecordMapper;

public class AccountRecordRepository
{
    private AccountRecordMapper arm;

    public AccountRecordRepository()
    {
        arm = new AccountRecordMapper();
    }
    
    public void voegToe(AccountRecord ar)
    {
        arm.addRecord(ar);
    }
    
    public void sluitAf()
    {
        arm.closeFiles();
    }

    public List<AccountRecord> geefAlleAccounts()
    {
        return arm.readRecords();
    }
}
