To create a service on Debian Linux 8.8:

10. apt-get update
20. apt-get install jsvc
30. Build the profile linux-service
40. cp metd /etc/init.d
50. chmod 755 /etc/init.d/metd
55. build the Maven profile linux-service
60. copy metd.jar, commons-cli-1.2.jar, commons-daemon-1.0.15.jar, commons-io-2.5.jar and log4j-1.22.17.jar to /home/zc/metd/lib.
70. copy request-locations.xml to /home/zc/metd/data/locations
80. copy config.properties to /home/zc/metd/props
90. copy wxfcs3hourly-bangor.properties etc. to /home/zc/metd/props/resources
100. service metd start
110. If the following error occurs:
        [Failed to start metd.service: Unit metd.service failed to load: No such file or directory.]
    Run this command: systemctl daemon-reload
    Rerun service metd start.
