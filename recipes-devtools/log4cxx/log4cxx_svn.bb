DESCRIPTION = "Apache log4cxx is a logging framework for C++"
HOMEPAGE = "http://logging.apache.org/log4cxx/"
SECTION = "libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

DEPENDS = "apr apr-util"

SRC_URI = "svn://svn.apache.org/repos/asf;module=incubator/log4cxx/trunk;protocol=http"
SRCREV = "1753033"

PR = "r0"

S = "${WORKDIR}/incubator/log4cxx/trunk"

inherit autotools-brokensep pkgconfig

BBCLASSEXTEND += "native"
