
This archetype creates a LOCKSS plugin project in which to store, test and build LOCKSS plugins

## Usage

To use the latest released version of this archetype execute the following maven command:

    mvn archetype:generate \
     -DarchetypeGroupId=org.lockss \
     -DarchetypeArtifactId=lockss-plugins-archetype \
     -DarchetypeVersion=1.4.0-SNAPSHOT

Follow the prompts:
- Define value for property 'groupId': <your.package>  (e.g., edu.<institution>)
- Define value for property 'artifactId': <your-artifact>  (e.g., plugin name)
- Define value for property 'version': <your-version>
- Define value for property 'package' <your-package>

Place your plugin files (.xml, .java, etc.) in
src/main/java/<your-package>/<plugin-name>/, and your tests in
src/test/java/<your-package>/<plugin-name>/.

Build the plugin(s) with mvn verify.  This will generate
<plugin-name>.jar files in target/pluginjars as well as run some
validation checks.


### Available properties

Name                        | Default | Description
----------------------------|---------|--------------------
groupId                     |         | Base Maven groupId
artifactId                  |         | Base Maven ArtifactId
version                     |         | Version
package                     |         | Java Source Package
artifactName                |         | Maven Project Name

