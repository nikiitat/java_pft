package stqa.pft.rest;

import com.jayway.restassured.RestAssured;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import static com.jayway.jsonpath.JsonPath.read;

/**
 * Created by nikitatertytskyi on 03.03.2018.
 */
public class TestBase {

    boolean isIssueOpen(int issueId) throws MalformedURLException, RemoteException {
        String statusById = getIssueStatusById(issueId);
        if (statusById.equals("Resolved")) {
            return true;
        }
        System.out.println("not fixed");
        return false;
    }

    public void skipIfNotFixed(int issueId) throws Exception {
        if (!isIssueOpen(issueId)) {
            throw new Exception("Test skipped because of issue " + issueId);
        }
    }

    protected String getIssueStatusById(int issueId) {
        String json = RestAssured.get("http://demo.bugify.com/api/issues/"+ issueId +".json").asString();
        List<String > status = read(json, "$.issues[*].state_name");
        return status.get(0);
    }
}
