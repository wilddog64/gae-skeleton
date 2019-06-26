How to get this project working in IntelliJ:
1) Make sure you have IntelliJ Cloud Code plug-in installed and configured.
2) Clone this code base.
3) Open it in IntelliJ.
4) Add App Engine Support by: Tools>Cloud Code>App Engine> Add App Engine support>Google App Engine Standart
5) Select the only module, click ok
6) Add a new artifact by: File>Project Structure>Artifacts
7)(You'll need Ultimate for this unless you can mimic exactly what the template does) 
Click on plus icon, select Web Application: Exploded> From Modules...
8) Select the only module, click ok
9) In output layout select WEB-INF, add file, select appengine-web.xml

You should be able to deploy to your app engine project. Make sure your project has a standart app engine environment.
