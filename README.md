# ci-cd-youtube-lessons

You need to pass this variable in the environment 

$AWS_REGION - your region in AWS

$STACK_NAME - name for cloudformation stack
  
$S3_BUCKET - name of EXISTING bucket, so we can push our template there

$TEMPLATE - name of the template

To communicate with your AWS account, the GitLab CI/CD pipelines expect AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY to be specified in your GitLab project settings. 
 CI/CD > Variables
