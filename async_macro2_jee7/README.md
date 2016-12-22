REST Archetype Service
===============================

Useful Commands
---------------

To build the whole project:

    mvn package

To build project including running integration tests:

    mvn verify

To run in Wildfly:

    mvn -N -Pwildfly cargo:run

To run in WebLogic:

    mvn -N -Pweblogic cargo:run

To redeploy in Wildfly

    mvn -N -Pwildfly cargo:redeploy

To redeploy in WebLogic

    mvn -N -Pweblogic cargo:redeploy

Admin console
-------------
The WebLogic console may be accessed from http://localhost:7001/console using username "weblogic" and password "weblogic1".
The JBoss console may be accessed from http://localhost:9990 using username "advisor1" and password "passw0rd".
