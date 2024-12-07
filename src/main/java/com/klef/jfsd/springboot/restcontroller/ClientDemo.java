package com.klef.jfsd.springboot.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientDemo {
	// Collection (List)
	
	List<Customer> customers = new ArrayList<Customer>();
	
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String demo() {
        return "<b>Hello Pawan</b>";
    }
    @GetMapping(path="/demo1")
    public String demo1() {
    	return "<b>Y22 JFSD</b>";
    }
    @GetMapping(path="/demo2")
    public int demo2() {
    	return 30829;
    }
    @GetMapping("demo3")
    	public String demo3(@RequestParam("id") int eid) {
    		return "ID="+eid;
    	}
    @GetMapping("demo4")
	public String demo4(@RequestParam("i") int x,@RequestParam("j") int y) {
		return Integer.toString(x+y);
	}
    @GetMapping("demo5")
    public String demo5(@RequestParam("fname") String x,@RequestParam("lname") String y) {
		return x.toUpperCase()+" "+y.toUpperCase();
	}
    @GetMapping("demo6/{id}")
    public String demo6(@PathVariable("id") int eid) {
		return "ID="+eid;
	}
    @GetMapping("demo07/{fname}/{lname}")
    public String formatNames(@PathVariable("fname") String fname, @PathVariable("lname") String lname) {
        return fname.toUpperCase() + " " + lname.toUpperCase();
    }
    
    // Add Customer
    
    @PostMapping("addcustomer")
    public String addcustomer(@RequestBody Customer customer)
    {
    	customers.add(customer);
    	return "Customer Added Successfully";
    }
    
    // view all customers
    
    @GetMapping("viewallcustomers")
    public List<Customer> viewallcustomers(){
    	return customers;
    }
    
    
    
}
