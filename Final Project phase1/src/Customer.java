import java.util.ArrayList;
public class Customer implements Comparable<Customer>{
	
String name;
String address;
String plan ;
int value =2 ;
ArrayList<String>List=new ArrayList<>();
ArrayList<String>Rented=new ArrayList<>();

Customer(String name ,String address,String plan)throws IllegalAccessException {
	this.name=name;
	this.address=address;   // constructors with parameters
	setPlan(plan);
}

public String getPlan() {
	return plan;
}

public void setPlan(String plan) throws IllegalAccessException  {
	if(plan.compareToIgnoreCase("Limit")==0 || plan.compareToIgnoreCase("unLimit")==0 ) {
		this.plan=plan;
	}// if the user enter plan not equal limit or unlimit an exception will be throw and the following sentence will be print 
	else
		throw new IllegalAccessException ("invalid plan");
}

public int getValue() {
	return value;
}

public void setValue(int value) {
	if(plan =="Limit") {
	this.value = value;
}
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public int compareTo(Customer o){
return this.getName().compareTo(o.getName());//compare according to the name of the customers 
}

@Override
public String toString() {
	return ""+name+" "+address+" "+plan+"";
}














}
