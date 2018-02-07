1. Es ist möglich das Datum auf der JAVA Application seite zu generieren mit
	setParameter(String name, java.util.Date value, TemporalType temporalType)

2. Es ist möglich das Datum auf datenbank seite zu generieren mit 
	dbo.myTable SET updatedDate=GETDATE() 