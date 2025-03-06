# Database connection
use strict;
use warnings;
use DBI;

sub connect_to_database {
    my $dbh = DBI->connect("DBI:mysql:database=dbname;host=localhost", "user", $DB_PASSWORD)
        or die "Connection Error: $DBI::errstr\n";
    print "Connected to database\n";
    return $dbh;
}