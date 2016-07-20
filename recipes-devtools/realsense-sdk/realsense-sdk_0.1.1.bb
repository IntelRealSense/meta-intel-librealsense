SUMMARY = "RealSense SDK"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4151db0f01967ef808d8b232acf49628"

DEPENDS = "librealsense opencv"
RDEPENDS_${PN} += "librealsense"

inherit cmake

SRC_URI = "git://github.com/IntelRealSense/realsense_sdk.git;branch=development \
	   file://libs_fix.patch \
	   file://skip_tests.patch \
"
SRCREV = "d85713b8246e9d2f147cd1a5c07a0951a32ea09c"

PR = "r1"

S = "${WORKDIR}/git"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg ${PN}-samples"

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS:BOOL=ON -Drun_tests:BOOL=OFF"

FILES_${PN} = "${bindir}/rs_projection_tool \
	       ${libdir}/*.so \
"

FILES_${PN}-samples += "${bindir}/*_sample"
