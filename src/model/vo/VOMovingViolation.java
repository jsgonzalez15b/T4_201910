package model.vo;

/**
 * Representation of a MovingViolation object
 */
public class VOMovingViolation implements Comparable<VOMovingViolation> {

	/**
	 * identificacion infraccion
	 */
	private int Id;
	/**
	 * lugar de la infraccion
	 */
	private String location; 
	/**
	 * fecha de la infraccion
	 */
	private String ticketIssueDate;
	/**
	 * valor pagado de la infraccion
	 */
	private double totalpaid; 
	/**
	 * identificador de accidente de la infraccion
	 */
	private String accidenIndicator; 
	/**
	 * descripcion infraccion
	 */
	private String description; 
	/**
	 * codigo de violacion de la infraccion
	 */
	private String violationcode; 
	/**
	 * fineAMT
	 */
	private double fineAMT;


	public VOMovingViolation(int pId, String pLocation, String pTicketIssueDate, double pTotoalpaid, String pAccidentIndicator, String pDescription, String pViolationCode, double pfineAMT){
		Id=pId;
		location=pLocation;
		ticketIssueDate=pTicketIssueDate;
		totalpaid=pTotoalpaid;
		accidenIndicator=pAccidentIndicator;
		description=pDescription; 		
		violationcode=pViolationCode; 
		fineAMT=pfineAMT;
	}
	
	
	/**
	 * @return id - Identificador �nico de la infracci�n
	 */
	public int objectId() 
	{
		// TODO 
		return Id;
	}	
	
	
	/**
	 * @return location - Direcci�n en formato de texto.
	 */
	public String getLocation()
	{
		// TODO
		return location; 
	}

	/**
	 * @return date - Fecha cuando se puso la infracci�n .
	 */
	public String getTicketIssueDate()
	{
		// TODO 
		return ticketIssueDate;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pag� el que recibi� la infracci�n en USD.
	 */
	public double getTotalPaid()
	{
		//TODO
		return totalpaid;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator()
	{
		// TODO 
		return accidenIndicator; 
	}
		
	/**
	 * @return description - Descripci�n textual de la infracci�n.
	 */
	public String  getViolationDescription()
	{
		// TODO 
		return description;
	}
	public String getViolationCode()
	{
		return violationcode;
	}
	
	public double getFINEAMT()
	{
		return fineAMT;
	}

	@Override
	public int compareTo(VOMovingViolation o)
	{
		// TODO
		//argumentos de la violacion recibida por parametro
		String fechaInfraccion = o.getTicketIssueDate();
		int idInfraccion = o.objectId();
		//sentencia de la comparacion
		int comparacion = 1;
		
		if(ticketIssueDate.compareToIgnoreCase(fechaInfraccion)==0)
		{
			comparacion= idInfraccion < Id? 1:-1;
		}
		else
		{
			comparacion=ticketIssueDate.compareToIgnoreCase(fechaInfraccion);
		}
		return comparacion;
	}
	
	public String toString()
	{
		// TODO 
		return Id+","+location+","+ticketIssueDate+","+totalpaid+","+accidenIndicator+","+description+","+violationcode+","+fineAMT;
	}
}
