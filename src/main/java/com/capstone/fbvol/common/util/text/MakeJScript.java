package com.capstone.fbvol.common.util.text;

/**
 * Business Logic ó�� �� Ư�� �޼��� �� action�� ó���� jscript ����
 * @author Administrator
 */
public class MakeJScript {

	public static String alert( String msg ) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<script language=javascript>    ");
		sb.append("	alert(\""+ msg +"\");          ");
		sb.append("</script>                       ");
		
		return sb.toString();
	}
	
	public static String alert( String msg, String cmd ) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<script language=javascript>     ");
		sb.append("	alert(\""+ msg +"\"); "+ cmd +" ");
		sb.append("</script>                        ");
		
		return sb.toString();
	}	
	
	public static String confirm( String msg, String cmd ) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<script language=javascript>        ");
		sb.append("	var conf = confirm(\""+ msg +"\"); ");
		sb.append("	if(conf) "+ cmd +"                 ");
		sb.append("</script>                           ");
		
		return sb.toString();
	}		
}
