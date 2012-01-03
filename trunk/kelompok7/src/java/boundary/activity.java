/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entity.DaftarLapangan;
import entity.DaftarUser;
import entity.lapangan;
import entity.members;
import entity.operator;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class activity extends Boundary {
    private operator operator;

    public activity() {
        super();
        setTemplate("/WEB-INF/activity.jsp");
    }

    @Override
    protected void process() {
      setMessage("");
        DaftarLapangan dl = new DaftarLapangan();
        if(validate_activity()){
            List<lapangan> i = dl.lapanganTerbaru();
            getRequest().setAttribute("daftar_lapangan", i.iterator());
        }
        else{
            try {
                getResponse().sendRedirect("listLapanganKosong");
            } catch (IOException ex) {
                Logger.getLogger(activity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            }
        }

    private boolean validate_activity(){
        DaftarLapangan dl = new DaftarLapangan();
        int xx = dl.getJumlahLapangan();
        
        if( xx == 0){
            return false;
        }

        return true;
    }  
}

