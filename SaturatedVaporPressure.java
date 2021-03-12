/*
  This utility class is used as a helper function in calculating
  enthalpy ( in a package ) for air at a given set of conditions.
  That equation uses metric variables. This overloaded method 
  converts a fahrenheit reading from the board output ( in any
  form ) to the equivalent saturated vapor pressure for that temperature.  
*/

public class SaturatedVaporPressure
{
	// Declare variables
	private double tempF;
	private final double BASE_KELVIN_TEMP = 273;
	
	// overloaded constructors
	public SaturatedVaporPressure( String f )
	{
		this.tempF = Double.parseDouble( f ) ;	
	}

	public SaturatedVaporPressure( double f )
	{
		this.tempF = f ;	
	}
	  
	public SaturatedVaporPressure( int f )
	{
		this.tempF = ( double ) f ;	
	}
	
	// setters
	public void setTempF( double f )
	{
		this.tempF = f;
	}
	  
	//getters
	public double getTempF( )
	{
		return tempF;
	}
	
	public double getSVP()
	{
		// convert to c
		double cent = 5/9 *( tempF - 32);
		
		// convert to kelvin
		double tempK = ( cent + BASE_KELVIN_TEMP );
		
		// equation in three parts
		double partA = ( 77.3450 + ( 0.0057 * tempK ) - ( 7235 / tempK) );
		double partB = Math.pow( tempK, 8.2 );
		double partC = Math.exp( partA );
		
		// gives results in pascals ( metric )
		double svp = ( partC / partB );
		
		// convert pascals to inches of mercury needed in other equations
		svp/= 3368.38867;
		
		return svp;
	}
}
