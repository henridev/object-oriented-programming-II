package tekstbestand.persistentie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import tekstbestand.domein.AccountRecord;

public class AccountRecordMapper
{

    private Formatter output;
    private Scanner input;

    private void openFileWrite()
    {
//tag::format[]
        try
        {
            output = new Formatter(Files.newOutputStream(Paths.get("src\\tekstbestand\\clients.txt"),StandardOpenOption.APPEND)); // <1>
        } 
        catch (InvalidPathException ie) // <2>
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } 
        catch (IOException ex) // <3>
        {
            System.err.println("Error creating file.");
            System.exit(1);
        }
//end::format[]

    }

    public void openFileRead()
    {
//tag::scan[]
        try
        {
            input = new Scanner(Files.newInputStream(Paths.get("src\\tekstbestand\\clients.txt"))); // <1>
        } 
        catch (InvalidPathException ie) // <2>
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } 
        catch (IOException ex) // <3>
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
//end::scan[]
    }

    public void addRecord(AccountRecord record)
    {
        if (output == null)
        {
            openFileWrite();
        }
//tag::format2[]
        try
        {
            output.format("%d %s %s %.2f%n", record.getAccount(), // <1>
                    record.getFirstName(), record.getLastName(),
                    record.getBalance());
        } catch (FormatterClosedException formatterClosedException) // <2>
        {
            System.err.println("Error writing to file.");
        }
//end::format2[]

    }

    public List<AccountRecord> readRecords()
    {
        if (input == null)
        {
            openFileRead();
        }

        List<AccountRecord> lijst = new ArrayList<>();
//tag::scan2[]
        try
        {
            while (input.hasNext())
            {
                lijst.add(new AccountRecord(input.nextInt(), input.next(), input.next(), input.nextDouble())); // <1>
            }
        } catch (InputMismatchException elementException) // <2>
        {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (NoSuchElementException elementException) // <3>
        {
            System.err.println("Element missing");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException) // <4>
        {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
//end::scan2[]
        return lijst;

    }

    public void closeFiles()
    {
        if (output != null)
        {
            output.close();
        }

        if (input != null)
        {
            input.close();
        }
    }
}
