
This archetype creates a minimal LOCKSS plugin project as a starting point for plugin development.


## Usage

To use the latest released version of this archetype execute the following maven command:

    mvn archetype:generate \
     -DarchetypeGroupId=org.lockss \
     -DarchetypeArtifactId=lockss-plugins-archetype \
     -DarchetypeVersion=1.0.0-SNAPSHOT

Follow the prompts:
Define value for property 'groupId': <your.group>
Define value for property 'artifactId': <your-artifact>
Define value for property 'version': <your-version>
Define value for property 'package' <your-group>

### Available properties

Name                        | Default | Description
----------------------------|---------|--------------------
groupId                     |         | Base Maven groupId
artifactId                  |         | Base Maven ArtifactId
version                     |         | Version
package                     |         | Java Source Package
artifactName                |         | Maven Project Name