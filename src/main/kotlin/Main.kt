import java.util.*

abstract class Employee(
    var firstName: String,
    var lastName: String,
    var exp: Int,
    var baseSalary: Double,
    var myManager: String
){
    open fun giveSalary(): Double{
if (exp > 2 && exp <= 5)
    baseSalary = baseSalary + 200
       else if (exp > 5)
           baseSalary = (baseSalary * 1.2) + 500
        return baseSalary
    }
}
class Developer(
    firstName: String,
    lastName: String,
    exp: Int,
    baseSalary: Double,
    myManager: String
) : Employee (firstName, lastName, exp, baseSalary, myManager){
}
class Designer (
    firstName: String,
    lastName: String,
    exp: Int,
    baseSalary: Double,
    myManager: String,
    var coef: Double
): Employee (firstName, lastName, exp, baseSalary, myManager){
    override fun giveSalary(): Double {
    return super.giveSalary() * coef
}
}
class Manager (
    firstName: String,
    lastName: String,
    exp: Int,
    baseSalary: Double,
    var team: MutableList<Employee> = mutableListOf()
): Employee (firstName, lastName, exp, baseSalary, myManager = "Null" ){
    fun teams(){team.forEach { Employee ->
        if (Employee.myManager == this.firstName)
            team.add(Employee)

    }}
    override fun giveSalary(): Double {
        val devCount = team.filterIsInstance<Developer>().count()
        val designerCount = team.filterIsInstance<Designer>().count()

        if (devCount > designerCount)
            return super.giveSalary() * 1.1 // baseSalary = baseSalary * 1.1
        if (devCount + designerCount > 5 && devCount + designerCount <= 10)
            return super.giveSalary() + 200 // baseSalary = baseSalary + 200
        if (devCount + designerCount > 10)
            return super.giveSalary() + 300
        return super.giveSalary()
    }}






class Department(
    var managers: MutableList<Manager> = mutableListOf()
){
    fun giveAllSalary(){
        managers.forEach { manager ->
        manager.giveSalary()
        manager.team.forEach { employee ->
        employee.giveSalary()
        }
        }
    }

}


fun main(){
 val dev1 = Developer("Darya","Siliznyova",3, 1630.0, "Agata")
 val dev2 = Developer("Kiril","Fyodorov",5, 1300.0, "Agata")
val dev3 = Developer("Mihail","Tihonov",7, 1400.0, "Arina")
    val dev4 = Developer("Mihail","Afonasiev",9, 1120.0, "Agata")
    val dev5 = Developer("Petr","Simonov",11, 1150.0, "Arina")
    val dev6 = Developer("Artemiy","Tihonov",13, 1100.0, "Agata")
    val dev7 = Developer("Sofia","Lapshina",17, 2600.0, "Agata")

    val designer1 = Designer("Varvara", "Sherbakova",4, 1000.0, "Arina", 0.7,)
    val designer2 = Designer("Vera", "Savina",7, 2700.0,"Arina", 0.4)
    val designer3 = Designer("Vasilisa", "Kolosova",10, 1200.0,"Agata", 0.7)
    val designer4 = Designer("Andrey", "Babushkin",13, 1500.0,"Agata", 0.9)

val manager1 = Manager("Agata", "Vasilyeva",8, 1200.0, mutableListOf())
val manager2 = Manager("Arina", "Kruglova",8, 1500.0, mutableListOf())


println("Salary of employee  " + dev1.firstName + " " + dev1.lastName + " : " + dev1.giveSalary())
    println("Salary of employee  " + dev2.firstName + " " + dev2.lastName + " : " + dev2.giveSalary())
    println("Salary of employee  " + dev3.firstName + " " + dev3.lastName + " : " + dev3.giveSalary())
    println("Salary of employee  " + dev4.firstName + " " + dev4.lastName + " : " + dev4.giveSalary())
    println("Salary of employee  " + dev5.firstName + " " + dev5.lastName + " : " + dev5.giveSalary())
    println("Salary of employee  " + dev6.firstName + " " + dev6.lastName + " : " + dev6.giveSalary())
    println("Salary of employee  " + dev7.firstName + " " + dev7.lastName + " : " + dev7.giveSalary())

    println("Salary of employee  " + designer1.firstName + " " + designer1.lastName + " : " + designer1.giveSalary())
    println("Salary of employee  " + designer2.firstName + " " + designer2.lastName + " : " + designer2.giveSalary())
    println("Salary of employee  " + designer3.firstName + " " + designer3.lastName + " : " + designer3.giveSalary())
    println("Salary of employee" + designer4.firstName + " " + designer4.lastName + " : " + designer4.giveSalary())

    println("Salary of employee " + manager1.firstName + " " + manager1.lastName + " : " + manager1.giveSalary())
    println("Salary of employee " + manager2.firstName + " " + manager2.lastName + " : " + manager2.giveSalary())
}