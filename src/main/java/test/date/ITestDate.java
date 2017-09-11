package test.date;

public interface ITestDate {

    static final long LARGE_FILE_MIN_SIZE = Long.parseLong( System.getProperty( "archive.backup.large.file.min.size", "10737418240" ) );
}
