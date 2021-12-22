package Class;

import java.io.Serializable;

import interf.Calculate_IF;

public class Calculate implements Calculate_IF, Serializable{
	 public String[] tach(String s, int indexdau) {
	        String s1 = "" ;
	        String s2 = "" ;
	        try {
	            s1 = s.substring(0, (indexdau )) ;
	            s2 = s.substring(indexdau +1) ;
	        }catch(Exception e) {
	            e.printStackTrace();
	        }

	        String arr[] = {s1, s2} ;
	        return arr;
	    }

	    public float tinhTongHieu(String s) {
	        int indexCong = s.lastIndexOf("+") ;
	        int indexTru = s.lastIndexOf("-") ;

	        if ( indexCong >= 0 || indexTru >= 0) {
	            if ( indexCong > indexTru) {
	                String[] a1 = tach(s, indexCong) ;
	                float a  =  tinhTongHieu(a1[0]) ;
	                float b  = tinhTongHieu(a1[1]) ;

	                return (a + b) ;
	            }else  {
	                String[] a1 = tach(s, indexTru) ;
	                float a  =  tinhTongHieu(a1[0]) ;
	                float b  = tinhTongHieu(a1[1]) ;

	                return (a - b) ;
	            }
	        }else {
	            float result  = 0;
	            try {
	                result = Float.parseFloat(s) ;
	            } catch (Exception e) {

	            }
	            return  (float) Math.floor(result * 100) / 100;
	        }

	    }
	    public float tinhTichThuong(String s ) {
	        int indexNhan = s.lastIndexOf("*") ;
	        int indexChia = s.lastIndexOf("/") ;


	        if ( indexNhan > 0 || indexChia > 0) {
	            if ( indexNhan > indexChia) {
	                String[] a1 = tach(s, indexNhan) ;
	                float a  =  tinhTichThuong(a1[0]) ;
	                float b  = tinhTichThuong(a1[1]) ;

	                float c = a * b ;
	                return (float) Math.floor(c * 100) /100;
	            }
	            else  {
	                String[] a1 = tach(s, indexChia) ;
	                float a  =  tinhTichThuong(a1[0]) ;

	                float b  = tinhTichThuong(a1[1]) ;
	                float c = 0 ;
	                try {
	                    c = a / b  ;
	                }catch(Exception e) {
//	                    txvOutput.setText("Error: "+e.getCause());
	                }

	                return (float) Math.floor(c * 100) /100 ;
	            }

	        }else {
	            float result = 0 ;
	            try {
	                result = (float) Math.floor(Float.parseFloat(s) * 100 ) /100   ;
	            } catch (Exception e) {
	                // TODO: handle exception

	            }
	            return result;
	        }
	    }
	    public int spliceTrai(String s) {
	        int indexCong = s.lastIndexOf("+") ;
	        int indexTru = s.lastIndexOf("-") ;

	        int maxTru = indexCong > indexTru ? indexCong : indexTru ;
	        if (maxTru > -1)
	            return maxTru ;
	        else
	            return -1 ;

	    }
	    public int splicePhai(String s) {

	        int indexNhan = s.indexOf("*") ;
	        int indexChia = s.indexOf("/") ;
	        int indexCong = s.indexOf("+") ;
	        int indexTru = s.indexOf("-") ;

	        int	minTru = -1 ;
	        if ( indexCong >= 0 && indexTru >= 0)
	            minTru = indexCong < indexTru ? indexCong : indexTru ;
	        else if (indexCong >= 0 )
	            minTru = indexCong ;
	        else if( indexTru >= 0)
	            minTru = indexTru ;
	        else minTru  = s.length() ;
	        return minTru ;

	    }
	    public String tinhHonHop(String s) {
	        int indexNhan = s.lastIndexOf("*") ;
	        int indexChia = s.lastIndexOf("/");
	        int index = indexNhan > indexChia ? indexNhan : indexChia ;
	        String[] s1 = tach(s, index) ;
	        int maxTrai = spliceTrai(s1[0]) ;
	        int minPhai = splicePhai(s1[1]) ;
	        String ss1 = "" ;
	        if (maxTrai > -1) {
	            ss1 = s1[0].substring(0 , maxTrai+1) ;
	        }else {
	            ss1 = "";
	            maxTrai = 0 ;
	        }
	        float ss2 = 0 ;
	        if (indexNhan > indexChia)
	            ss2 = (float) Math.floor((tinhTichThuong(s1[0].substring(maxTrai)) * tinhTichThuong(s1[1].substring(0, minPhai))) * 100)/ 100  ;
	        else
	            ss2 = (float) Math.floor((tinhTichThuong(s1[0].substring(maxTrai)) / tinhTichThuong(s1[1].substring(0, minPhai))) * 100)/ 100  ;
	        String ss3 = s1[1].substring(minPhai) ;
	        return  getResult(ss1+""+ss2+""+ss3)+"";
	    }
	    public float getResult(String s) {
	        int indexNhan = s.indexOf("*") ;
	        int indexChia = s.indexOf("/") ;
	        if( indexNhan >= 0 || indexChia >= 0 ) {
	            int indexCong = s.indexOf("+") ;
	            int indexTru = s.indexOf("-") ;
	            if( indexCong >= 0 || indexTru >= 0 ) {
	                float result = 0 ;
	                try {
	                    result = getResult(tinhHonHop(s)) ;
	                }catch(Exception e) {
	                    e.printStackTrace();
	                }
	                return result ;
	            }else {
	                float result = 0 ;
	                try {
	                    result = tinhTichThuong(s)  ;
	                }catch(Exception e) {
	                    e.printStackTrace();
	                }
	                return result ;
	            }


	        }else {
	            float result = 0 ;
	            try {
	                result = tinhTongHieu(s) ;
	            }catch(Exception e ){
	                e.printStackTrace();
	            }
	            return result ;
	        }

	    }


	    @Override
	    public String giaiPTBac2(float a, float b, float c) {
	        // kiểm tra các hệ số
	        if (a == 0) {
	            if (b == 0) {
	               return ("Phương trình vô nghiệm!");
	            } else {
	                return ("Phương trình có một nghiệm: "
	                        + "x = " + (-c / b));
	            }
	           
	        }
	        // tính delta
	        float delta = b*b - 4*a*c;
	        float x1;
	        float x2;
	        // tính nghiệm
	        if (delta > 0) {
	            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
	            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
	            return("Phương trình có 2 nghiệm là: "
	                    + "x1 = " + x1 + " và x2 = " + x2);
	        } else if (delta == 0) {
	            x1 = (-b / (2 * a));
	            return("Phương trình có nghiệm kép: "
	                    + "x1 = x2 = " + x1);
	        } else {
	        	return("Phương trình vô nghiệm!");
	        }
	    }
	    
	   
}
