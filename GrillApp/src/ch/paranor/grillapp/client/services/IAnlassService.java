package ch.paranor.grillapp.client.services;

import java.util.List;

import ch.paranor.grillapp.shared.model.Anlass;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("anlass")
public interface IAnlassService extends RemoteService {

	public List<Anlass> getAnlaesse();

}
