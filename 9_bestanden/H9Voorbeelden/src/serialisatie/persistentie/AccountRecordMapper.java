package serialisatie.persistentie;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import serialisatie.domein.AccountRecord;

public class AccountRecordMapper
{

    private ObjectOutputStream output;
    private ObjectInputStream input;

    private void openFileSchrijven()
    {
//tag::write[]    	
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(
                    Paths.get("src\\serialisatie\\accounts.ser"))); // <1>

        } catch (InvalidPathException ie) // <2>
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) // <3>
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
//end::write[]        

    }

    public void addRecord(AccountRecord record)
    {
        if (output == null)
        {
            openFileSchrijven();
        }
//tag::write2[]
        try
        {
            output.writeObject(record); // <1>
        } catch (IOException ex) // <2>
        {
            System.err.println("Error writing to file.");
        }
//end::write2[]        

    }

    public void openFileLezen()
    {
//tag::read[]
        try
        {
            input = new ObjectInputStream(Files.newInputStream(
                    Paths.get("src\\serialisatie\\accounts.ser"))); // <1>
        } catch (InvalidPathException ie) // <2>
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException io) // <3>
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
//end::read[]
    }

    public List<AccountRecord> readRecords()
    {
        if (input == null)
        {
            openFileLezen();
        }

        List<AccountRecord> lijst = new ArrayList<>();
//tag::read3[]
        try
        {
            while (true)
            {
//tag::read2[]            	
                AccountRecord record = (AccountRecord) input.readObject(); // <1>
//end::read2[]                
                lijst.add(record);

            }
        } catch (EOFException e) // <2>
        {
        }catch (ClassNotFoundException ex) // <3>
        {
            System.err.print("ongeldige objectstream");
            System.exit(1);
        } catch (IOException e) // <4>
        {
            System.err.println("Error reading file.");
            System.exit(1);
        } 
        return lijst;
//end::read3[]
    }

    public void closeFile()
    {
        if (output != null)
        {
            try
            {
                output.close();
            } catch (IOException ex)
            {
                System.exit(1);
            }
        }

        if (input != null)
        {
            try
            {
                input.close();
            } catch (IOException ex)
            {
                System.exit(1);
            }
        }
    }
}
