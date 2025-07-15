def call(String emailSubject, String emailBody, String recipients) {
        emailext(
            subject: emailSubject,
            body: emailBody,
            to: recipients,
            mimeType: 'text/html'
        )
    echo "Email sent with subject: ${emailSubject} to recipients: ${recipients}"
}
