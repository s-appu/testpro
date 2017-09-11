package test.some;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class MyOptionals {

    public static void main( final String args[] ) {
        // simpleOptionalTest();
        optionalTestInner();
    }

    static void simpleOptionalTest() {
        final String name = "Swaroop";
        final String age = null;

        final List<String> myList = new ArrayList<>();

        final Optional<String> nameOptional = Optional.ofNullable( name );
        nameOptional.ifPresent( n -> System.out.println( "The name is " + n ) );
        Optional.ofNullable( age ).ifPresent( n -> System.out.println( "The age is " + n ) );
        System.out.println( "If not -- " + Optional.ofNullable( name ).orElse( "Appu" ) );
        System.out.println( "If not -- " + Optional.ofNullable( age ).orElse( "34" ) );

        System.out.println( Optional.ofNullable( myList ).isPresent() );
    }

    static void optionalTestInner() {

        final Optional<Department> optDept = createDepartment();
        // final Optional<Department> optDept = Optional.empty();

        System.out.println( optDept.map( Department::getDeptName ).orElse( "Biology" ) );
        final Address add = null;

    }

    static Optional<Department> createDepartment() {
        final Department computerDept = new Department();
        computerDept.setDeptName( "Computer Science Dept" );
        final Employee e1 = new Employee();
        e1.setName( "Test 1" );
        e1.setLocation( "NYC" );

        final Employee e2 = new Employee();
        e2.setName( "Test 2" );
        e2.setLocation( "SFO" );
        computerDept.setEmployees( Arrays.asList( e1, e2 ) );
        return Optional.ofNullable( computerDept );
    }

    @Test
    public void testOptionalMap() {

        final Employee e1 = new Employee( "testLocation", "testName" );
        final Employee nullEmployee = null;

        Optional.ofNullable( e1 ).ifPresent( e -> System.out.println( "Name " + e.getName() ) );
        Optional.ofNullable( nullEmployee ).ifPresent( e -> System.out.println( "Name " + e.getName() ) );
        final String name = Optional.ofNullable( nullEmployee ).map( e -> e.getName() ).orElse( "" );
        System.out.println( "Null Name " + name );
        final String notNullName = Optional.ofNullable( e1 ).map( e -> e.getName() ).orElse( "" );
        System.out.println( "Not null Name " + notNullName );

    }

}

class Employee {

    private String location;
    private String name;
    private Address address;

    public Employee() {
    }

    public Employee( final String location, final String name, final Address address ) {
        super();
        this.location = location;
        this.name = name;
        this.address = address;
    }

    public Employee( final String location, final String name ) {
        this( location, name, null );
    }

    public String getName() {
        return this.name;
    }

    public void setName( final String name ) {
        this.name = name;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation( final String location ) {
        this.location = location;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress( final Address address ) {
        this.address = address;
    }
}

class Department {

    private String deptName;
    private Employee manager;
    private List<Employee> employees;

    public String getDeptName() {
        return this.deptName;
    }

    public void setDeptName( final String deptName ) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public void setEmployees( final List<Employee> employees ) {
        this.employees = employees;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager( final Employee manager ) {
        this.manager = manager;
    }

}

class Address {
    private String city;
    private String country;

    public String getCity() {
        return this.city;
    }

    public void setCity( final String city ) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry( final String country ) {
        this.country = country;
    }
}
