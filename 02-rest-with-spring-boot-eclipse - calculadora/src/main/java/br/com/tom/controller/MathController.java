package br.com.tom.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.tom.converter.converterNumero;
import br.com.tom.exception.UnsupportedMathOperentionException;
import br.com.tom.math.SimpleMath;


@RestController
public class MathController {
	
	private SimpleMath math = new SimpleMath();
	
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {
		
		if((!converterNumero.isNumeric(numberOne)) || (!converterNumero.isNumeric(numberTwo))){
			throw new UnsupportedMathOperentionException("Please, Digite somente números!");
			
		}
	//Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
	return math.sum(converterNumero.convertToDouble(numberOne), converterNumero.convertToDouble(numberTwo));
	}
		
	@RequestMapping(value = "/subtrair/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {			
		if((!converterNumero.isNumeric(numberOne)) || (!converterNumero.isNumeric(numberTwo))){
			throw new UnsupportedMathOperentionException("Please, Digite somente números!");	
			}
		//Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return math.sub(converterNumero.convertToDouble(numberOne), converterNumero.convertToDouble(numberTwo));
		}
	
	@RequestMapping(value = "/multiplicar/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multi(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {			
		if((!converterNumero.isNumeric(numberOne)) || (!converterNumero.isNumeric(numberTwo))){
			throw new UnsupportedMathOperentionException("Please, Digite somente números!");	
			}
		//Double multi = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return math.multi(converterNumero.convertToDouble(numberOne), converterNumero.convertToDouble(numberTwo));
		}
	
	@RequestMapping(value = "/dividir/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {			
		if((!converterNumero.isNumeric(numberOne)) || (!converterNumero.isNumeric(numberTwo))){
			throw new UnsupportedMathOperentionException("Please, Digite somente números!");	
			}
		//Double div = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return math.div(converterNumero.convertToDouble(numberOne), converterNumero.convertToDouble(numberTwo));
		}
	
	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double med(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception  {			
		if((!converterNumero.isNumeric(numberOne)) || (!converterNumero.isNumeric(numberTwo))){
			throw new UnsupportedMathOperentionException("Please, Digite somente números!");	
			}
		//Double med = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
		return math.media(converterNumero.convertToDouble(numberOne), converterNumero.convertToDouble(numberTwo));
		}
	
	@RequestMapping(value = "/raiz/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception  {			
		if(!converterNumero.isNumeric(number)){
			throw new UnsupportedMathOperentionException("Please, Digite somente números!");	
			}  	
		return math.squareRoot(converterNumero.convertToDouble(number));

		}

//	private Double convertToDouble(String strNumber) {
//		if(strNumber == null) return 0d;
//		
//		String number = strNumber.replaceAll(",", ".");
//		if(isNumeric(number)) return Double.parseDouble(number);
//		return 0d;
//	}
//
//
//	private boolean isNumeric(String strNumber) {
//		if(strNumber == null) return false;
//		
//		String number = strNumber.replaceAll(",", ".");
//		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
//		//return number.matches("[-+]?[0-9]*\\.?[0-9]+");
//	}
}
