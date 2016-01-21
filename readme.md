# librealsense Yocto Layer

This layer adds the packages necessary for adding support for Intel® RealSense™ cameras via [librealsense](https://github.com/IntelRealSense/librealsense) to your Yocto distribution.

## How To Use This Layer

The layer has been tested with Yocto Poky 1.8 (fido) and Wind River IDP 3.X.

This layer depends on the following layers (this is already included with Wind River Linux):

meta-openembedded: http://cgit.openembedded.org/meta-openembedded/

For authentication the recipes in this layer rely on SSH.
You MUST have been granted permission to access the 'librealsense' repository and have the relevant SSH keys setup in github (see here for details: https://help.github.com/articles/generating-ssh-keys/#step-4-add-your-ssh-key-to-your-account)

## How To Build (Yocto)

Checkout the branch which corresponds with your version of Yocto (e.g. fido)

Add the following lines to your bblayers.conf file in 'build/conf':

BBLAYERS += "/PATH/TO/LAYERS/meta-intel-librealsense"
BBLAYERS += "/PATH/TO/LAYERS/meta-openembedded/meta-oe"

Add the following to the end of your local.conf file in 'build/conf'

require include/intel-librealsense.inc

The layer does not require a desktop environment however in order to use the example applications it is recommended to include one (e.g. core-image-sato).

## How To Build (Wind River)

Checkout the branch which corresponds with your version of Wind River (e.g. idp_3.x)

Include the following in your configure command:

--with-layer=/PATH/TO/LAYERS/meta-intel-librealsense
--with-package=librealsense,librealsense-examples

## License

This project is Copyright (C) 2015 Intel Corporation. Please the LICENSE file in the `custom-licenses\` folder.