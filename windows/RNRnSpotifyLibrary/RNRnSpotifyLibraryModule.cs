using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Rn.Spotify.Library.RNRnSpotifyLibrary
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNRnSpotifyLibraryModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNRnSpotifyLibraryModule"/>.
        /// </summary>
        internal RNRnSpotifyLibraryModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNRnSpotifyLibrary";
            }
        }
    }
}
