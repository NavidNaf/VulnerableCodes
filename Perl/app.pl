#!/usr/bin/perl
use strict;
use warnings;
use CGI qw(:standard);
use DBI;
use lib './';  # Include local library path
require 'config.pl';
require 'database.pl';

print header;

# Vulnerable endpoint for SQL Injection
if (param('id')) {
    my $user_id = param('id');
    my $query = "SELECT * FROM users WHERE id = $user_id";  # SQL Injection vulnerability
    # Execute query...

    print "User data";
}

# Vulnerable endpoint for XSS
if (param('name')) {
    my $name = param('name');
    print "<h1>Hello, $name</h1>";  # XSS vulnerability
}