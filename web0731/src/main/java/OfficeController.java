import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.*;

@Path("/offices")
public class OfficeController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOffice() {
		OfficeDAO dao=new OfficeDAO();
		List<Office> f=dao.getAll();
		if(f!=null && f.size()>0)
			return Response.ok().entity(f).build();
		else
			return Response.status(Status.NO_CONTENT).build();
	}
   @GET
   @Path("/add")
   public Response saveExample() {
	   OfficeDAO dao=new OfficeDAO();
	   boolean f=dao.saveOffice();
	   if(f)
		 return  Response.ok().build();
	   else
		 return  Response.status(Status.NO_CONTENT).build();
   }
}
