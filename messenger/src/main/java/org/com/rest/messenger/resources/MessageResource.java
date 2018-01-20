package org.com.rest.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.com.rest.messenger.model.Message;
import org.com.rest.messenger.service.MessageService;

@Path("/mes")
public class MessageResource {

	MessageService ms = new MessageService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {

		return ms.getAllMessages();
	}

	@POST
	@Path("/messageID")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message txt) {
		return ms.addMessage(txt);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageID") long id, Message upText) {
		upText.setId(id);
		return ms.updateMessage(upText);
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("messageID") long id) {
		return ms.removeMessage(id);
	}

	@GET
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageID") long id) {

		return ms.getMessage(id);

	}

}
