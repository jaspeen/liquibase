package liquibase.snapshot;

import liquibase.database.Database;
import liquibase.exception.DatabaseException;
import liquibase.exception.UnexpectedLiquibaseException;
import liquibase.structure.DatabaseObject;
import liquibase.structure.core.Column;
import liquibase.structure.core.Relation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

public class MockSnapshotGeneratorFactory extends SnapshotGeneratorFactory{
    private List<DatabaseObject> objects;

    public MockSnapshotGeneratorFactory(DatabaseObject... objects) {
        this.objects = new ArrayList<DatabaseObject>();
        if (objects != null) {
            this.objects.addAll(Arrays.asList(objects));
        }
    }

    @Override
    public DatabaseSnapshot createSnapshot(DatabaseObject[] examples, Database database, SnapshotControl snapshotControl) throws DatabaseException, InvalidExampleException {
        return new MockDatabaseSnapshot(objects, examples, database, snapshotControl);
    }

    public void addObjects(DatabaseObject... objects) {
        for (DatabaseObject object : objects) {
            this.objects.add(object);
        }

    }

    public void removeObjects(DatabaseObject... objects) {
        for (DatabaseObject object : objects) {
            this.objects.remove(object);

        }

    }


}
