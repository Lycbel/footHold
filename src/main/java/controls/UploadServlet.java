package controls;
import modules.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private static final String UPLOAD_DIRECTORY = "img";

    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    private List<String> urls = new ArrayList<String>();
    private List<String> names = new ArrayList<String>();
    User user ;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: form need include enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


        user = (User)request.getSession().getAttribute("user");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setFileSizeMax(MAX_FILE_SIZE);

        upload.setSizeMax(MAX_REQUEST_SIZE);

        upload.setHeaderEncoding("UTF-8");

        String uploadPath = getServletContext().getRealPath(".") + File.separator + UPLOAD_DIRECTORY;


        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                //loop in from
                for (FileItem item : formItems) {
                    // the item not in form
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator +user.getUserID()+ dateFormat.format(new Date());
                        urls.add(filePath);
                        names.add(fileName);
                        File storeFile = new File(filePath);
                        // print path
                        System.out.println(filePath);
                        // save the file
                        item.write(storeFile);
                        request.setAttribute("message",
                                "success!");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.print(ex.toString());
            request.setAttribute("message",
                    "error: " + ex.getMessage());
        }

        HouseBean hb = new HouseBean(request,urls,names,user);
        // jump to index

        getServletContext().getRequestDispatcher("/index.jsp").forward(
                request, response);
    }
}
