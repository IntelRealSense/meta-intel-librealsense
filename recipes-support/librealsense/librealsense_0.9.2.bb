require librealsense.inc

SRC_URI = "https://github.com/IntelRealSense/librealsense/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "4d41105e56b02a59fff944cd6e41dc2c"
SRC_URI[sha256sum] = "c4682aa8ba4e55f09d8f7fcb7745e1b0ec95124811c4bea9ded1348193480ec4"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"
