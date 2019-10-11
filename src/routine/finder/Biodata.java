package routine.finder;



public class Biodata extends Koneksi {
    String URL = "http://slasstec.com/routine/server.php";
    String url = "";
    String response = "";

    public String tampilBiodata() {
        try {
            url = URL + "?operasi=view";
           // System.out.println("URL Tampil Biodata: " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    
    public String inserVersion(String nama, String alamat) {
        try {
            url = URL + "?operasi=insertversion&nama=" + nama + "&alamat=" + alamat;
           // System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    
    
    

    public String inserBiodata(String dayString, String courseString, String teacherString, String timeString, String roomString) {
        try {
            url = URL + "?operasi=insert&day=" + dayString + "&course=" + courseString+"&teacher=" + teacherString+"&time=" + timeString + "&room=" + roomString;
          //  System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String getBiodataById(int id) {
        try {
            url = URL + "?operasi=get_biodata_by_id&id=" + id;
          //  System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String updateBiodata(String id, String nama, String alamat) {
        try {
            url = URL + "?operasi=update&id=" + id + "&nama=" + nama + "&alamat=" + alamat;
           // System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

    public String deleteBiodata(int id) {
        try {
            url = URL + "?operasi=delete&id=" + id;
          //  System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }
    
    public String truncateBiodata() {
        try {
            url = URL + "?operasi=truncate";
         //   System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        } catch (Exception e) {
        }
        return response;
    }

}