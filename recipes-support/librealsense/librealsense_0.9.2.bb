require librealsense.inc

SRC_URI = "https://github.com/IntelRealSense/librealsense/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "8968c0cf709bd92e0c05b434f3580b5d"
SRC_URI[sha256sum] = "86df7c1aea864fef964804effd9d08733be66283e6b69152538f0d143b4dda07"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"
