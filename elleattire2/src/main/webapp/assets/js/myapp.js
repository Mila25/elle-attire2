$(function() {
	//SOLVING THE ACTIVE MENU PROBLEM
	switch(menu){
		
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break; 
	default:
		$('#home').addClass('active');
		break;
	
	
	}
	
	
});
