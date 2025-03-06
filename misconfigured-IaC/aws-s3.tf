resource "aws_s3_bucket" "my_bucket" {
  bucket = "my-vulnerable-bucket"
  acl    = "public-read"  # Vulnerable: Public access to the bucket
}