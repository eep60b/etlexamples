#
# Function for fresh plain deployment

import os
import fnmatch
import os.pathsep

from java.io import File
from java.io import FileInputStream

username = None
password = None
adminUrl = None
applicationPath = None
planPath = None
targetServers = None

def init():
	try:
		propInputStream = FileInputStream('src/main/resources/config/bh-deployer.properties')
		configProps = Properties()
		configProps.load(propInputStream)
		
		global username
		username = configProps.get("username")
		
		global password
		password = configProps.get("password")
		
		global adminUrl
		adminUrl = configProps.get("admin.url")
		
		global applicationPath
		applicationPath = configProps.get("application.path")
	
		global planPath
		planPath = configProps.get("deployment.plan.path")
	
		global targetServers
		targetServers = configProps.get("target.servers")

	except:
		print 'Failded to read configuration parameters from WeblogicConfig.properties.'
		print ''
		exit()


def conn():
	try:
		print 'Connecting to the admin server ' + adminUrl + '......';
		print ''
		connect(username, password, adminUrl)
		print 'Successfully connected to server ' + adminUrl
	except:
		print 'Failed to connect to the server'
		exit()
				
# All the application will be undeployed. This is necessary 		
def stop_and_undeploy_all_applications():

	try:
		print 'Undeploying All Applications.........'	
		domainConfig()
		dumpStack()
		myApplications = cmo.getAppDeployments()
		
		domainRuntime()
		
		for nextApplication in myApplications:
			appname = nextApplication.getName()
			progress = stopApplication(appname, block='true')
			progress = undeploy(appname, block = 'true')
		
		print 'All applications have been successfully undeployed.'
		print ''
	except:
		print 'Failded to configure the server ' + managedServerName
		print ''
		exit()	
			
def deploy_bh_application():
	
	try:
		file = File(applicationPath)
		planFile = File(planPath)
		deploymentDir = file.getAbsolutePath()
		for filePath in os.listdir(deploymentDir):
			if fnmatch.fnmatch(filePath, '*.ear'):
				sourcefile = deploymentDir + os.sep + filePath
				applicationName = filePath.replace('.ear', '').replace('.EAR','')
				deploy(appName=applicationName, path=sourcefile, targets=targetServers, planPath=planFile.getAbsolutePath())
				print 'The Baker Hughes Migrator has been successfully deployed.'
				print''
	except:
		print 'Failed to deploy the Baker Hughes Migrator.'
		print ''
		exit()	

try:
	init()		
	conn()	
	stop_and_undeploy_all_applications()
	deploy_bh_application()	
except:
	dumpStack()
	exit()