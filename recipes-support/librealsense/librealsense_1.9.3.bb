require librealsense.inc

SRC_URI = "https://github.com/IntelRealSense/librealsense/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "5cc0b759f9936687d3042691d58316a2"
SRC_URI[sha256sum] = "a4778c69d26b6c569bcd6f64017cb66728839119851b3a072057386d5cf27fba"

PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"

FILES_${PN}-examples += "\
	${EXAMPLES_DIR}/cpp-callback \
	${EXAMPLES_DIR}/cpp-motion-module \
"
FILES_${PN}-graphical-examples += "\
	${EXAMPLES_DIR}/cpp-callback-2 \
	${EXAMPLES_DIR}/cpp-multi-threading-1 \
	${EXAMPLES_DIR}/cpp-multi-threading-2 \
	${EXAMPLES_DIR}/cpp-stride \
"
