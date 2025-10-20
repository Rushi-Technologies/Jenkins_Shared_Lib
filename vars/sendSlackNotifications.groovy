def call(String buildStatus, String slackChannelName) {
  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESS'
  def colorName = 'GREEN'
  def colorCode =  '#00FF00'
  // Override default values based on build status
  if (buildStatus == 'SUCCESS') {
    colorName = 'GREEN'
    colorCode = '#00FF00'
  } else {
    colorName = 'RED'
    colorCode = '#FF0000'
  }
  if (slackChannelName == null || slackChannelName.trim().length() == 0) {
      slackSend (color: colorCode, message: summary)
  }else{
    slackSend (channel: "{slackChannelName}", color: "${colorcode}", message: "Build - ${buildStatus} : ${env.JOB_NAME} #${env.BUILD_NUMBER} - URL: ${env.BUILD_URL}")
  }
}
