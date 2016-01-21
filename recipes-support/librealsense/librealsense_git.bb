SUMMARY = "A cross-platform library for capturing data from the RealSense F200, SR300 and R200 cameras"
SECTION = "libs"
AUTHOR = "Scott Ware"

LICENSE = "LICENSE"
LIC_FILES_CHKSUM = "file://LICENSE;md5=E3C3CB4D897DF0AED5D13BA0D41612AB"

DEPENDS = "libpng libusb1 libglu glfw"
RDEPENDS_${PN} = "bash"
RDEPENDS_${PN}-examples = "librealsense"
RDEPENDS_${PN}-graphical-examples = "libgl-mesa librealsense"

SRC_URI = "git://git@github.com/IntelRealSense/librealsense.git;protocol=ssh"
SRCREV = "${AUTOREV}"

PR = "r0"

inherit pkgconfig

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "\
    'CC=${CC}' \
    'CXX=${CXX}' \
    'CFLAGS=${CFLAGS} -std=c11 -fPIC -pedantic -DRS_USE_$(BACKEND)_BACKEND $(LIBUSB_FLAGS)' \
    'CXXFLAGS=${CXXFLAGS} -std=c++11 -fPIC -pedantic -mssse3 -O3 -Wno-missing-field-initializers -Wno-switch -Wno-multichar -DRS_USE_$(BACKEND)_BACKEND $(LIBUSB_FLAGS)' \
"

do_install () {
	install -d "${D}${bindir}"
	install -d "${D}${bindir}/examples/assets"
	install -m 755 ${S}/bin/* ${D}${bindir}
	install -m 0644 ${S}/examples/assets/* ${D}${bindir}/examples/assets

	install -d "${D}${libdir}"
	install -m 0644 ${S}/lib/librealsense.so ${D}${libdir}

	install -d "${D}${includedir}/${PN}"
	install -m 0644 ${S}/include/${PN}/*.h ${D}${includedir}/${PN}
	install -m 0644 ${S}/include/${PN}/*.hpp ${D}${includedir}/${PN}

	install -d "${D}${sysconfdir}/udev/rules.d"
	install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d

	install -d "${D}${prefix}/local/bin"
	install -m 755 ${S}/config/usb-R200-in ${D}${prefix}/local/bin
	install -m 755 ${S}/config/usb-R200-in_udev ${D}${prefix}/local/bin
}

PACKAGES = "${PN} ${PN}-dbg ${PN}-dev ${PN}-examples ${PN}-graphical-examples"

FILES_${PN} = "${libdir}/* ${sysconfdir}/udev/rules.d/* ${prefix}/local/bin/*"
FILES_${PN}-dev += "${includedir}/${PN}"
FILES_${PN}-examples += "${bindir}/c-enumerate"
FILES_${PN}-graphical-examples += "\
	${bindir}/c-capture \
	${bindir}/c-pointcloud \
	${bindir}/cpp-alignimages \
	${bindir}/cpp-alignimages \
	${bindir}/cpp-capture \
	${bindir}/cpp-config-ui \
	${bindir}/cpp-multicam \
	${bindir}/cpp-pointcloud \
	${bindir}/cpp-restart \
	${bindir}/examples/assets \
"

# Configuration is not required
do_configure[noexec] = "1"
