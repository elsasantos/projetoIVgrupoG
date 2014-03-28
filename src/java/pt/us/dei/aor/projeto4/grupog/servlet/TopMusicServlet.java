/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.us.dei.aor.projeto4.grupog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt.uc.dei.aor.projeto4.grupog.ejbs.MusicFacade;
import pt.uc.dei.aor.projeto4.grupog.entities.Music;
import pt.uc.dei.aor.projeto4.grupog.managebeans.RequestPlaylistMb;

/**
 *
 * @author User
 */
@WebServlet(name = "TopMusicServlet", urlPatterns = {"/topmusic"})
public class TopMusicServlet extends HttpServlet {

    @Inject
    private MusicFacade musicFacade;

    @Inject
    private RequestPlaylistMb requestPlayMb;

    private List<Music> musicAllpop;
    private List<Music> topTenmusic;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String resp = request.getParameter("topten");
        response.setContentType("text/xml;charset=UTF-8");

        PrintWriter out = null;
//        if (resp.equals("mostpopular")) {
        musicAllpop = musicFacade.showMostPopularMusics();
//            StringBuffer sb = new StringBuffer();
        if (resp != null) {
            if (resp.equals("all")) {
                try {
                    /* TODO output your page here. You may use following sample code. */

                    out = response.getWriter();

                    out.println("<table>");
                    out.println("<th>Top</th>");
                    out.println("<th>Title</th>");
                    out.println("<th>Artist</th>");
                    out.println("<th>Album</th>");
                    out.println("<th>Music Year</th>");
                    out.println("<th>User</th>");
                    int a = 1;
                    for (Music m : musicAllpop) {
                        out.println("<tr><td>" +m.getPlaylists().size() + "</td>");
                        out.println("<td>" + m.getTitle() + "</td>");
                        out.println("<td>" + m.getArtist() + "</td>");
                        out.println("<td>" + m.getAlbum() + "</td>");
                        out.println("<td>" + m.getMusic_year() + "</td>");
                        out.println("<td>" + m.getUser().getName() + "</td></tr>");
                        a++;

                    }
                    out.println("</table>");

                } catch (Exception e) {
                    out.println("erro");
                }
            } else if (resp.equals("topten")) {
                topTenmusic = musicFacade.showTopTenPopularMusics();
                StringBuffer sb = new StringBuffer();
                try {
                    /* TODO output your page here. You may use following sample code. */

                    out = response.getWriter();
                    out.println("<table>");
                    out.println("<th>Top</th>");
                    out.println("<th>Title</th>");
                    out.println("<th>Artist</th>");

                    for (int i = 0; i < topTenmusic.size(); i++) {
                        out.println("<tr><td>" + (i + 1) + "º" + "</td>");
                        out.println("<td>" + topTenmusic.get(i).getTitle() + "</td>");
                        out.println("<td>" + topTenmusic.get(i).getArtist() + "</td></tr>");

                    }
                    out.println("</table>");

                } catch (Exception e) {
                    out.println("erro");
                }

            } 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public List<Music> getMusicAllpop() {
        return musicAllpop;
    }

    public void setMusicAllpop(List<Music> musicAllpop) {
        this.musicAllpop = musicAllpop;
    }

    public List<Music> getTopTenmusic() {
        return topTenmusic;
    }

    public void setTopTenmusic(List<Music> topTenmusic) {
        this.topTenmusic = topTenmusic;
    }

}
