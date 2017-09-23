package com.rental.controllers;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rental.beans.BookingDetails;
import com.rental.beans.CarDetails;
import com.rental.beans.Customer;
import com.rental.beans.LocationDetails;
import com.rental.service.BookingService;
import com.rental.service.CustomerService;


@Controller
public class RentalController {
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value="/locationsearch", method=RequestMethod.GET)
	public ModelAndView getLocationPage(@RequestParam("user_id")String user_id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id",user_id);
		mav.setViewName("locationsearch");
		return mav;
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView getSearchResults(@RequestParam("qry")String query,@RequestParam("user_id")String user_id ){
		ModelAndView mav = new ModelAndView();
		mav.addObject("user_id",user_id);
		mav.setViewName("locationsearch");
		System.out.println(bookingService.getLocationIds("Ohio"));
		mav.addObject("locations",bookingService.getLocationIds(query));
		/*mav.addObject("carousel",newsServiceImpl.getNewsForCarouselByNewsType(""));
		mav.addObject("newsMetric",newsServiceImpl.getRecomendedNewsMetric());
		mav.addObject("chartdata",newsServiceImpl.getChartData());
			alert(position.coords.latitude);
 		x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;
 		"/rent-a-car/reservation?car_id=AA315&user_id=${user_id}"window.location=link+"from_date="$("#fromdate").val()+"&to_date="$("#todate").val();
*/
		
		return mav;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public ModelAndView getSearchResults(){
		ModelAndView mav = new ModelAndView("test");
		
		return mav;
	}
	
	@RequestMapping(value="/reservation",method=RequestMethod.GET)
	public  ModelAndView getReservationDetailsPage(@RequestParam("car_id")String car_id,@RequestParam("user_id")String user_id,@RequestParam("from_date")String from_date,@RequestParam("to_date")String to_date){ 
		ModelAndView mav = new ModelAndView("reservationpage");
	    CarDetails n= bookingService.getCarDetails(car_id);
	    
	    mav.addObject("cardetails",n);
	    
		mav.addObject("customerdetails",customerService.getCustomerDetails(user_id));
		mav.addObject("from_date",from_date);
		mav.addObject("to_date",to_date);
		
		//mav.addObject("booking",bd);
		
		return mav;
	}
	
	@RequestMapping(value="/reservation",method=RequestMethod.POST)
	public ModelAndView getAddNewsPageWithData(@RequestParam("from_date")String from_date,@RequestParam("to_date")String to_date,@RequestParam("car_id")
			String car_id,@RequestParam("user_id")String user_id)
	{
		 CarDetails n= bookingService.getCarDetails(car_id);
		 DateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
		    Date frm_date=new Date();
		    Date to_dte=new Date();
			try {
				frm_date = df.parse(from_date);
				  to_dte =  df.parse(to_date);  
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		   
		int diffInDays = (int) ((to_dte.getTime() - frm_date.getTime()) / (1000 * 60 * 60 * 24));
		BookingDetails bd = new BookingDetails();
		bd.setCar_id(car_id);
		bd.setUser_id(user_id);
		bd.setRental_ext(false);
		bd.setTotal_cost(n.getCar_price()*(diffInDays));
		bd.setBooking_date(new Date());
		bd.setLocation_id(String.valueOf(n.getLocation_id()));
		
		bd.setFrom_date(frm_date);
		bd.setTo_date(to_dte);
		
	
		ModelAndView mav = new ModelAndView("confirmationpage");
		//System.out.println(news);
		
		
		mav.addObject("car", n);
		Customer cu = customerService.getCustomerDetails(bd.getUser_id());
		mav.addObject("user",cu);
		LocationDetails ld = bookingService.getLocationDetailsFromLocationId(bd.getLocation_id());
		mav.addObject("loc", ld);
		//go to Db And persist latest news
		bookingService.persistBooking(bd);
		mav.addObject("bookingid",bd.getBooking_id());
		mav.addObject("booking",bd);
		
		return mav;
	}
	/*@RequestMapping(value="/reservation",method=RequestMethod.GET)
	public ModelAndView getWelcomePage(){
		 ModelAndView mav = new  ModelAndView("reservationpage");
		 mav.addObject("customer",new Customer());
		
		 return mav;
		 
		 
		
}*/
/*	@RequestMapping(value="/confirmation",method=RequestMethod.GET)
	public ModelAndView getConfirmationPage(){
		ModelAndView mav = new ModelAndView("confirmationpage");
		
		
		return mav;
	}*/
	
	@RequestMapping(value="/confirmation",method=RequestMethod.GET)
	public ModelAndView getConfirmationPagewithId(@RequestParam("query")String id){
		System.out.println(id);
		ModelAndView mav = new ModelAndView("confirmationpage");
		BookingDetails bd = bookingService.getConformationData(id);
		mav.addObject("booking", bd);
		CarDetails cd = bookingService.getCarDetails(bd.getCar_id());
		mav.addObject("car", cd);
		Customer cu = customerService.getCustomerDetails(bd.getUser_id());
		mav.addObject("user",cu);
		LocationDetails ld = bookingService.getLocationDetailsFromLocationId(bd.getLocation_id());
		mav.addObject("loc", ld);
		return mav;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getWelcomePage() {
		ModelAndView mav = new ModelAndView("home");
		Customer c=new Customer();
		mav.addObject("validate",1);
		/*c.setUser_firstname("serdftyghu");
		c.setUser_firstname("fghjk");
		c.setUser_lastname("dfghjk");
		c.setUser_password("fdghjkl");
		c.setUser_phonenumber("fghjkl");
		c.setUser_cardexp(new Date());
		c.setUser_cardno("4567890");
		c.setUser_city("rtyuio");*/
		mav.addObject("user",c );
		return mav;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView getsignedup(@ModelAttribute("user") Customer user) {
		System.out.println(user);
		ModelAndView mav = new ModelAndView("home");
		System.out.println(user);
		bookingService.persistCustomerDetails(user);
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView getloggedup(@RequestParam("userid")String id,@RequestParam("password")String pwd) {
		System.out.println(id);
		ModelAndView mav ;
		
		String custid=bookingService.validateUser(id, pwd);
		if(custid==""){
			mav = new ModelAndView("home");
			Customer c=new Customer();
			mav.addObject("user",c );
			mav.addObject("validate",0);
		}
		else{
			mav = new ModelAndView("locationsearch");
			mav.addObject("user_id",custid);
		}
		return mav;
	}
	
}
