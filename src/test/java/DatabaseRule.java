import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "muturia", "DontAsk12");
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteAnimalsQuery = "DELETE FROM animals *;";
      String deleteDangerQuery = "DELETE FROM danger *;";
      con.createQuery(deleteAnimalsQuery).executeUpdate();
      con.createQuery(deleteDangerQuery).executeUpdate();
    }
  }
}